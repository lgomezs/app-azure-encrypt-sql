package pe.commons.azure.sql.config;

import com.microsoft.sqlserver.jdbc.SQLServerColumnEncryptionAzureKeyVaultProvider;
import com.microsoft.sqlserver.jdbc.SQLServerColumnEncryptionKeyStoreProvider;
import com.microsoft.sqlserver.jdbc.SQLServerConnection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@ConditionalOnProperty(name = "spring.datasource.dataSourceProperties.ColumnEncryptionSetting", havingValue = "true", matchIfMissing = false)
public class DataSourceSqlBeanPostProcessor implements BeanPostProcessor {

  @Value("${azure.keyvault.client-id}")
  private String clientId;
  @Value("${azure.keyvault.client-key}")
  private String clientSecret;

  @Override
  public Object postProcessBeforeInitialization(final Object bean, final String beanName) throws BeansException {
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(final Object bean, final String beanName) throws BeansException {
    if (bean instanceof DataSource) {
      Assert.notNull(clientId, "azure.keyvault.client-id must not be null!");
      Assert.notNull(clientSecret, "azure.keyvault.client-key must not be null!");
      try {
        log.info("initializing DataSource AlwaysEncryption Vault provider");
        SQLServerColumnEncryptionAzureKeyVaultProvider akvProvider =
          new SQLServerColumnEncryptionAzureKeyVaultProvider(clientId, clientSecret);

        Map<String, SQLServerColumnEncryptionKeyStoreProvider> keyStoreMap = new HashMap<String, SQLServerColumnEncryptionKeyStoreProvider>();
        keyStoreMap.put(akvProvider.getName(), akvProvider);

        SQLServerConnection.registerColumnEncryptionKeyStoreProviders(keyStoreMap);
      } catch (SQLException ex) {
        log.error(ex.getMessage());
        throw new FatalBeanException(ex.getMessage());
      }
    }
    return bean;

  }
}
