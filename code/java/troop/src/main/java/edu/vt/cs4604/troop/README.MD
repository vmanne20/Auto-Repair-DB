Files in this directory

* **Scout.java** - Plain old java object (POJO aka Entity), uses annotations
to describe persistence
* **ScoutRepository.java** - extends JpaRepository is the interface that the 
controller will manipulate
* **ScoutController.java** - provides entry points (urls) into the application.
Manipulates data in the database through the repository.

