@echo off
javac --module-path "C:\Program Files\Java\javafx-sdk-23.0.2\lib" --add-modules javafx.controls,javafx.graphics Cube3D.java
java -Dprism.verbose=true -Dprism.debug=true -Dprism.forceGPU=true -Dprism.order=d3d,sw --module-path "C:\Program Files\Java\javafx-sdk-23.0.2\lib" --add-modules javafx.controls,javafx.graphics Cube3D 