package mastermind.models.Files;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

import mastermind.models.Color;
import mastermind.models.Combination;
import mastermind.models.DAO.CombinationDAO;

abstract class CombinationFileDAO extends CombinationDAO implements FileDAO{
	
	CombinationFileDAO(Combination combination) {
		super(combination);
	}

	public void save(FileWriter fileWriter) {
		try {
			for (Color color : this.combination.getColors()) {
				fileWriter.write(color.ordinal() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void load(BufferedReader bufferedReader) {
		try {
			for (int i = 0; i < Combination.getWidth(); i++) {
				int ordinal = Integer.parseInt(bufferedReader.readLine());
				this.combination.addColor(Color.getInstance(ordinal));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
