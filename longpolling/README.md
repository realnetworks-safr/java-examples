# longpolling-java
## Example of SAFR feature of Long Polling in Java to be used as reference 

In order to change configuration default configuration, the properties under __{user.home}\safr\longpolling\app.properties__ may be used, when not provided, the default ones(the same ones below) will be used.  
```
safr.userId=userid  
safr.password=password  
safr.directory=main  
safr.events.url=https://cv-event.int2.real.com  
```

## Running the Application ##
`javar -jar longpolling-0.0.1-SNAPSHOT.jar` or even `./longpolling-0.0.1-SNAPSHOT.jar` as it´s an executable springboot application

## Logging
Logging will be generated at __{user.home}\safr\longpolling\app.log__ by default
