## Continuum take home assigmnet

Used Spring Boot and Hibernate to setup autowiring of JPA entity with database table schema. Flyway migration script to setup table and initial seed data.
 H2 databse is setup for data persistence. use http://localhost:8080/h2 to access H2 database consol and query table. 
  * Make sure jdbc url is jdbc:h2:file:~/itemsdb There is no password input, just click connect.
 
 ContinuumApplication.java launches the program (SpringBoot entry point).
 
 Head over to http://localhost:8080/items to view the returned query list in JSON format. Recommend using Postman (a Google chrom app) to for a better nested list view.

 
 ## Resource Usage and Database access
 
 A single self-referencing table was used. This is optimum for reducing redundancy by having duplicate data across multiple tables and also requires the list amount of maintenance and synchronization between tables. The database is accessed once when we query and most of the heavy lifting is being done by java.
 
 ## Complexity analysis
 
 The recursive call that is made when striping the Item object so that we can easily process it is the most costly operation. Parsing the returned list of Item entity objects does not work because the Item objects are bulky and result in a stack overflow. In order to easily process this list of entities I had to use DTO (data transaction object) to strip the Item object to just the information we need.
 
 This process is costly because the program is recursively making a liter ItemDTO object from each Item object and its liked child Items associated with it. For `n` number if Items assuming each has a smaller number of children say `c` number of children, we are visiting n nodes and every time we visit a node we have to do `n-1` visits for all  of its children and their children. Thus `n * (n-1)^c = O(n)^c`  
 
 This is not a scalable program as the run-time complexity gets exponentially higher with as the nesting of Items gets deeper. A better implementation would be to implement the table as two tables. Table 1 is Item and Table 2 is SubItems. Table 2 will have a composite key {Item Id, SubItemId}. Although this results in redundancy and more maintenance on the DB side, it will alleviate the number of operations java will have to do as a result of a bulky Item object. The database will do most of the work by querying and the subItems table for list of subItems and tehre will be no need to massage the data on the java side. This will reduce complexity to `O(n)`
