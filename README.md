# ScoutMasters CS4604 Project

## Team Members
* rquintin
*  ...

## Project Description
The Scoutmaster for a local Scout troop would like to track which scouts have attended scouting trips. Each trip occurs on a specific date and at a specific location. Some trips require a minimum age or scout rank in order to attend.

Each scout has a name, date of birth and rank.

Develop a system to track scouts, trips and which scouts have attended each trip.

## Entity Relationship

The entities in this project are a *ScoutTrip* and a *Scout*. A Scout *Attends* a ScoutTrip. 

A ScoutTrip is uniquely identified by the *TripDate*.
A Scout is uniquely identified by the *Name*.
Many Scouts Attend many ScoutTrips.

![ER Diagram](diagrams/entity-relationship.png  "ER Diagram")

## Relational

The diagram below shows the entity-relationship diagram converted to a relational schema.

![Relational Diagram](diagrams/relational.png "Relational Diagram")

The corresponding sql can be found [here](sql/install.sql).

