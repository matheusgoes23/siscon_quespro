package br.edu.ufersa.sicon_quespro;

import br.edu.ufersa.sicon_quespro.controller.LoginController;
import br.edu.ufersa.sicon_quespro.controller.PrimaryController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class FxApplication extends Application {

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);
        this.applicationContext = new SpringApplicationBuilder()
                .sources(SiConQuesProApplication.class)
                .run(args);
    }

    @Override
    public void start(Stage stage) {
        FxWeaver fxWeaver = applicationContext.getBean(FxWeaver.class);
//        Parent root = fxWeaver.loadView(PrimaryController.class);
        Parent root = fxWeaver.loadView(LoginController.class);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.getIcons().add(new Image("file:/views/img/books.gif"));
    }

    @Override
    public void stop() {
        this.applicationContext.close();
        Platform.exit();
    }
}
