package userInterface;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Game;
import model.Pacman;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Logger;
import Thread.PacmanThread;

public class PacmanController  {

	private ArrayList<Arc> pacmans;

	@FXML
	private Pane pane;

	@FXML
	private Stage stage;

	private PacmanThread pac;

	private Game pacmanGame;
	
	@FXML
    private Label labelResultsRebounds;

	// METHODS

	public void paint() {
		pacmans = new ArrayList<>();
		ArrayList<Pacman> pacs = pacmanGame.getArrayPac();
		MouseEvent e = (MouseEvent) pane.getOnMouseClicked();
		if(e!=null)
		System.out.println("Imprimir"+ e.getX());
		
		for (int i = 0; i < pacs.size(); i++) {
			Pacman pacM = pacs.get(i);
			Arc pac = new Arc(pacM.getX(), pacM.getY(), pacM.getRadius(), pacM.getRadius(), 45, 270);
			pac.setFill(pacM.getColor());
			pac.setType(ArcType.ROUND);
			//Creating the mouse event handler 
		      EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() { 
		         @Override 
		         public void handle(MouseEvent e) { 
		            System.out.println("Le di click al pacman"+pac.getId() + " x " +e.getX()+ " y " + e.getY()); 
		            pac.setFill(Color.DARKSLATEBLUE);
		            pane.getChildren().remove(pac);
		            
		         } 
		      }; 
		      pac.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
			pacmans.add(pac);
			pane.getChildren().add(pac);
		}
		pac = new PacmanThread(pacmanGame, this);
		pac.start();
	}

	// METHODS GETTERS & SETTERS
	public ArrayList<Arc> getPacmanOpen() {
		return pacmans;
	}

	public void setPacmanOpen(ArrayList<Arc> pacmanOpen) {
		this.pacmans = pacmanOpen;
	}

	@FXML
	void OnLoad(ActionEvent event) throws IOException{
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		File file = fileChooser.showOpenDialog(stage);
		if (file != null) {
			try {
				BufferedReader bf = new BufferedReader(new FileReader(file));

				String linea = bf.readLine();
				while (linea != null) {
					if (linea.contains("#nivel")) {
						linea = bf.readLine();
						pacmanGame = new Game(Integer.parseInt(linea));
					} else if (linea.contains("#radio")) {
						linea = bf.readLine();
						while (linea != null) {
							String datos[] = linea.split(" ");
							System.out.println(linea);
							Pacman p = new Pacman(Double.parseDouble(datos[0]), Double.parseDouble(datos[1]),
									Double.parseDouble(datos[2]), Double.parseDouble(datos[3]), datos[4],
									Integer.parseInt(datos[5]), Boolean.parseBoolean(datos[6]));
							pacmanGame.getArrayPac().add(p);
							linea = bf.readLine();
						}
					}
					linea = bf.readLine();
				}
			} catch (IOException e) {
				// TODO: handle exception
				Logger.getLogger("Exception OnLoad");
			}
		}
		paint();
	}

	@FXML
	public void OnSave() throws IOException {
		File file = new File("data/newPacmanGame.txt");
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(pacmans);
		oos.close();
		fos.close();
	}
	
	@FXML
	void OnExit(ActionEvent event) {
		System.exit(0);
	}
	
	@FXML
    void onAbout(ActionEvent event) {
    	Alert info = new Alert(AlertType.INFORMATION);
    	info.setTitle("Pac-Man");
    	info.setHeaderText(null);
    	info.initStyle(StageStyle.UTILITY);
    	info.setContentText(" ABOUT PACMAN GAME \n\n"+
    	"In the load option choose the file that you wat to play.\n"+
    	"You have to click the Pacman´s before they hit a border of the pane. "+
    	"Every time the pacman hit the border, the rebound increase one point, "+
    	"and the pacman is going to change of color.In the end the person with less "+
    	"rebounds points can be in the hall of fame. "+
    	"By Marisol Giraldo");
    	info.show();
    }

	public Label getLabelResultsRebounds() {
		return labelResultsRebounds;
	}

	public void setLabelResultsRebounds(String labelResultsRebounds) {
		this.labelResultsRebounds.setText(labelResultsRebounds);
	}
	
	public void changeColor(int i, Color color) {
		
		pacmans.get(i).setFill(color);
	}
}
