<div align="center"><h1 align="center">Compétitions Sportives</h1></div>

## About the project

  The purpose of this project is to simulate matches between competitors in two different types of competition (League, Tournament & Master, Journalists & Bookmakers).

## Date & version

  24/11/2022 V.3

## Authors

  LOUKILI Houssam.

## User Instructions
  
  At first, you will have to clone to project using the following command:
  
  HTTPS:

  * `git clone https://github.com/lifeofhoussam/Competition-Sportive.git`

  or SSH:
  
  * `git clone git@github.com:lifeofhoussam/Competition-Sportive.git`

  
## Compile the project
   
  To compile, use the command:
  
  * `mvn package`
  
## Documentation
  
  To generate the documentation use the command:
  
  * `mvn javadoc:javadoc`
  
  You can then open the index.html file and browse all the files.
  
## Start the games
  
  To start use the command:
  
  * `java -cp target/competitionsportive-3.0-SNAPSHOT.jar competition.CompetitionMain competitiontype( L or T or M16 or M24 or M32 )  <teamsList>`
  
  For example:
  
  * `java -cp target/competitionsportive-3.0-SNAPSHOT.jar competition.CompetitionMain M16 LOSC PSG OM BARCA MANUTD LENS MANCITY BAYERN BENFICA ACMILAN JUVENTUS CHELSEA ARSENAL TOTTENHAM NAPOLI INTER`
  
## UML diagram 

  ![Screenshot](/uml/UMLDiagram.png)

