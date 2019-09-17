# Azure Always Encrypted (Database Engine) 

 # Application
	
 This library demonstrate how to protect sensitive data (such as password, credit cards, etc) in Azure SQL database.
		
 ![Screenshot from running application](img/architecture.png?raw=true "Screenshot insert")
			
   Modules:  
         - appcommonssql (Azure sql fields encryption library).        
         - app-service-sql (Spring Boot example)
      
  ## REQUISITOS
  
   1. Generate a column master key in the Azure Key Vault:
  
   - Create Azure Key Vault using Portal or CLI. 
       [link] https://docs.microsoft.com/en-us/azure/key-vault/quick-create-portal
   - Grant the user that would encrypt the columns Get, List, Create, WrapKey, UnwrapKey, Encrypt, Decrypt, Verify, and
      Sign permissions to the key vault.
        [link] https://docs.microsoft.com/en-us/azure/sql-database/sql-database-always-encrypted-azure-key-vault
   
   2. Open Microsoft SQL Server Management Studio
   
      Configure columns to encrypt:
      
      ![Screenshot from running application](img/sql1.png?raw=true "Screenshot insert")
      
      ![Screenshot from running application](img/sql2.png?raw=true "Screenshot insert")
      
      ![Screenshot from running application](img/sql3.png?raw=true "Screenshot insert")
      
      ![Screenshot from running application](img/sql4.png?raw=true "Screenshot insert")         
              
  ## compile  appcommonssql
	 
	 cd appcommonssql
	 mvn clean install
	 
  ## compile  app-service-sql
  
    cd app-service-sql
    mvn clean install
    
  # Build & Run
  
    cd app-service-sql\src\main\docker
    docker-compose up  
    
    Service execute: 
    
    GET: http://localhost:8080/albums
    
    PUT:  http://localhost:8080/albums
        Body Json
        {
        	"id":4,
        	"title":"test",
        	"artist":"test",
        	"releaseYear":"1982",
        	"genre": "Pop",
            "trackCount": 0
        }
       
   ![Screenshot from running application](img/insert1.png?raw=true "Screenshot insert")
     
     
   Select data in SQL:
   
   ![Screenshot from running application](img/select1.png?raw=true "Screenshot select sql")
     
        
  ## Referencias
    
   [link] https://dzone.com/articles/azure-sql-with-pcf-spring-boot-applications-part-2
    
    
    
	 
	 
  