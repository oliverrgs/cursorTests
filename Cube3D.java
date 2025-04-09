import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.stage.Stage;
import javafx.animation.RotateTransition;
import javafx.util.Duration;
import javafx.scene.transform.Rotate;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.AmbientLight;
import javafx.scene.PointLight;
import javafx.scene.layout.Pane;
//TESTX
public class Cube3D extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            System.out.println("Starting 3D application...");
            
            // Create multiple boxes in different positions
            Box box1 = createBox(100, 100, 100, Color.RED, 100, 100, 0);
            Box box2 = createBox(100, 100, 100, Color.BLUE, 300, 100, 0);
            Box box3 = createBox(100, 100, 100, Color.GREEN, 100, 300, 0);
            Box box4 = createBox(100, 100, 100, Color.YELLOW, 300, 300, 0);
            Box box5 = createBox(100, 100, 100, Color.PURPLE, 200, 200, 100);
            
            System.out.println("Created boxes at different positions");

            // Add ambient light
            AmbientLight light = new AmbientLight(Color.WHITE);
            System.out.println("Added light");

            // Create root group with all boxes
            Group root3D = new Group();
            root3D.getChildren().addAll(box1, box2, box3, box4, box5, light);
            System.out.println("Created root group");

            // Create a container for 3D
            Pane container = new Pane(root3D);
            container.setPrefSize(500, 500);
            System.out.println("Created container");

            // Create scene
            Scene scene = new Scene(container, 500, 500, true, SceneAntialiasing.BALANCED);
            scene.setFill(Color.BLACK);
            System.out.println("Created scene");

            // Set up camera
            PerspectiveCamera camera = new PerspectiveCamera(true);
            camera.setTranslateX(250);
            camera.setTranslateY(250);
            camera.setTranslateZ(-400);
            camera.setFieldOfView(200);
            scene.setCamera(camera);
            System.out.println("Set up camera at: " + camera.getTranslateX() + ", " + camera.getTranslateY() + ", " + camera.getTranslateZ());

            // Add rotation to all boxes
            addRotation(box1, 3);
            addRotation(box2, 4);
            addRotation(box3, 5);
            addRotation(box4, 6);
            addRotation(box5, 7);
            System.out.println("Started rotations");

            // Set up stage
            primaryStage.setTitle("Multiple 3D Cubes");
            primaryStage.setScene(scene);
            primaryStage.show();
            System.out.println("Showed stage");
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private Box createBox(double width, double height, double depth, Color color, double x, double y, double z) {
        Box box = new Box(width, height, depth);
        box.setTranslateX(x);
        box.setTranslateY(y);
        box.setTranslateZ(z);
        
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(color);
        material.setSpecularColor(Color.WHITE);
        material.setSpecularPower(32.0);
        box.setMaterial(material);
        
        System.out.println("Created " + color + " box at: " + x + ", " + y + ", " + z);
        return box;
    }

    private void addRotation(Box box, double seconds) {
        RotateTransition rotate = new RotateTransition(Duration.seconds(seconds), box);
        rotate.setAxis(Rotate.Y_AXIS);
        rotate.setByAngle(360);
        rotate.setCycleCount(RotateTransition.INDEFINITE);
        rotate.play();
    }

    public static void main(String[] args) {
        System.setProperty("prism.verbose", "true");
        System.setProperty("prism.debug", "true");
        System.setProperty("prism.forceGPU", "true");
        launch(args);
    }
} 