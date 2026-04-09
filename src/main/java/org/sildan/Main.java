package org.sildan;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.fx_viewer.FxViewer;
import org.graphstream.ui.fx_viewer.FxViewPanel;
import org.graphstream.ui.javafx.FxGraphRenderer;
import org.sildan.model.NodePoint;

public class Main extends Application {

    private static final String UI_LABEL = "ui.label";

    @Override
    public void start(Stage stage) {
        Graph graph = new SingleGraph("Demo");

        graph.setAttribute("ui.stylesheet",
                """
                        node { size: 25px;
                        fill-color: #4f8cff;
                        text-size: 18;
                        text-alignment: above;} edge
                        { size: 2px; fill-color: gray;
                        }"""
        );

        graph.setAttribute("ui.quality");
        graph.setAttribute("ui.antialias");

        NodePoint node_a = new NodePoint("A");
        NodePoint node_b = new NodePoint("B");
        NodePoint node_c = new NodePoint("C");
        NodePoint node_d = new NodePoint("D");

        graph.addNode(node_a.value()).setAttribute(UI_LABEL, node_a.value());
        graph.addNode(node_b.value()).setAttribute(UI_LABEL,node_b.value());
        graph.addNode(node_c.value()).setAttribute(UI_LABEL,node_c.value());
        graph.addNode(node_d.value()).setAttribute(UI_LABEL,node_d.value());

        node_a.createEdgeTo(graph,node_b);
        node_b.createEdgeTo(graph,node_c);
        node_c.createEdgeTo(graph,node_d);

        FxViewer viewer = new FxViewer(graph, FxViewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
        viewer.enableAutoLayout();

        FxViewPanel viewPanel = (FxViewPanel) viewer.addDefaultView(false, new FxGraphRenderer());

        StackPane root = new StackPane(viewPanel);
        Scene scene = new Scene(root, 800, 600);

        stage.setTitle("GraphStream + JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}