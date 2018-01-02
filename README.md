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

### KbS öffentlicher Verkehr

* [http://localhost:8888/oereb/getegrid/xml/SO0200002601/992](http://localhost:8888/oereb/getegrid/xml/SO0200002601/992)
* [http://localhost:8888/oereb/extract/reduced/xml/geometry/CH870679603216](http://localhost:8888/oereb/extract/reduced/xml/geometry/CH870679603216)
* [http://oereb-web-service-dev-env.eu-central-1.elasticbeanstalk.com/oereb/extract/reduced/xml/geometry/CH870679603216](http://oereb-web-service-dev-env.eu-central-1.elasticbeanstalk.com/oereb/extract/reduced/xml/geometry/CH870679603216)

## Running OEREB web service
`docker run -p 8888:8888 -e OEREB_DB_PASS=XXXXXXXXXXXX sogis/oereb-web-service:latest`

## Map
* [https://s.geo.admin.ch/77bda69701](https://s.geo.admin.ch/77bda69701)
* [https://s.geo.admin.ch/77c9c106ab](https://s.geo.admin.ch/77c9c106ab)

## Coding / Refactoring thoughts
* Every xml element has a service class returning the jaxb element(s).
* Repositories: What is the input (geometry, egrid, t_id)? What is the output?
* Service classes and repos: "get xxx by _egrid_ AND e.g. restriction theme" would be the kleinste gemeinsame nenner and would always work (? to be validated). But needs more sql.
* Achtung: JaxbElements do not know about t_id and the geometry encoding is... ...silly (sorry).
* Rename geometry attribute according to XSD name.
* Service classes need a withImages/withGeometry parameter.
* how to handle Mehrsprachigkeit? Not that we want it but do not write ugly code.
