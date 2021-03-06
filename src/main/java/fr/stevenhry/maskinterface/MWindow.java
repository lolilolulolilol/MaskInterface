package fr.stevenhry.maskinterface;

import fr.stevenhry.maskinterface.tab.MaskTab;
import fr.stevenhry.maskinterface.util.JSONMessage;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBar;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MWindow extends Application {

    private static HostServices hostServices;
    private BorderPane borderPane;

    public static void openURL(String url) {
        hostServices.showDocument(url);
    }

    @Override
    public void start(Stage primaryStage) {
        hostServices = getHostServices();

        primaryStage.setTitle(JSONMessage.getMessage("window.name"));
        primaryStage.setMaximized(false);
        //primaryStage.setResizable(false);
        primaryStage.sizeToScene();

        primaryStage.getIcons().add(new Image(MWindow.class.getResourceAsStream("/images/MI_icon.png")));

        NavigationBar navigationBar = new NavigationBar(this);
        navigationBar.setMaxWidth(Double.MAX_VALUE);

        borderPane = new BorderPane();
        borderPane.setTop(navigationBar);
        setCenterPane(MaskTab.getCurrentTab().getTabManager());

        Scene scene = new Scene(borderPane);
        scene.setRoot(borderPane);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setCenterPane(Pane pane) {
        borderPane.setCenter(pane);
    }
}