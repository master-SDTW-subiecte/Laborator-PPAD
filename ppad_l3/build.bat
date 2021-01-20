e:
cd e:\ppad_workspace\ppad_l3\waldo\src
javac compute\Compute.java compute\Task.java
jar cvf compute.jar compute\*.class

copy compute.jar e:\ppad_workspace\ppad_l3\jones\public
move compute.jar e:\ppad_workspace\ppad_l3\ann\public
 

cd e:\ppad_workspace\ppad_l3\ann\src
javac -cp e:\ppad_workspace\ppad_l3\ann\public\compute.jar engine\ComputeEngine.java

cd e:\ppad_workspace\ppad_l3\jones\src
javac -cp  e:\ppad_workspace\ppad_l3\jones\public\compute.jar client\ComputePi.java client\Pi.java
mkdir e:\ppad_workspace\ppad_l3\jones\public\classes\client
copy client\Pi.class e:\ppad_workspace\ppad_l3\jones\public\classes\client