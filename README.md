# oereb-web-service
OEREB web service implementation with Spring Boot. 


## Sample requests
* [http://localhost:8888/oereb/getegrid/xml/?XY=2598098,1225627](http://localhost:8888/oereb/getegrid/xml/?XY=2598098,1225627)
* [http://localhost:8888/oereb/getegrid/xml/?GNSS=47.18159,7.41353](http://localhost:8888/oereb/getegrid/xml/?GNSS=47.18159,7.41353)
* [http://localhost:8888/oereb/getegrid/xml/SO0200002546/336](http://localhost:8888/oereb/getegrid/xml/SO0200002546/336)

* [http://localhost:8888/oereb/getegrid/xml/2540/Flughafenstrasse/117](http://localhost:8888/oereb/getegrid/xml/2540/Flughafenstrasse/117)
* [http://localhost:8888/oereb/getegrid/xml/2540/Flughafenstrasse/](http://localhost:8888/oereb/getegrid/xml/2540/Flughafenstrasse/)

* [http://localhost:8888/oereb/extract/reduced/xml/geometry/CH870672603279](http://localhost:8888/oereb/extract/reduced/xml/geometry/CH870672603279)

* [http://localhost:8888/oereb/getegrid/xml/2540/Flughafenstrasse/63](http://localhost:8888/oereb/getegrid/xml/2540/Flughafenstrasse/63)
* [http://localhost:8888/oereb/getegrid/xml/SO0200002546/343](http://localhost:8888/oereb/getegrid/xml/SO0200002546/343)
* [http://localhost:8888/oereb/extract/reduced/xml/geometry/CH340632730960](http://localhost:8888/oereb/extract/reduced/xml/geometry/CH340632730960)

* [http://oereb-web-service-dev-env.eu-central-1.elasticbeanstalk.com/oereb/getegrid/xml/?XY=2598098,1225627](http://oereb-web-service-dev-env.eu-central-1.elasticbeanstalk.com/oereb/getegrid/xml/?XY=2598098,1225627)

## Running OEREB web service
`docker run -p 8888:8888 -e OEREB_DB_PASS=XXXXXXXXXXXX sogis/oereb-web-service:latest`

## Map
* [https://s.geo.admin.ch/77bda69701](https://s.geo.admin.ch/77bda69701)