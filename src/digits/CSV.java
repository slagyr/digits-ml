package digits;

import java.io.BufferedReader;
import java.io.FileReader;

public class CSV
{
  public static short[][] trainingImages() throws Exception
  {
    BufferedReader reader = new BufferedReader(new FileReader("data/train.csv"));
    short[][] result = new short[42000][784];

    reader.readLine(); // Get rid of header
    for(int i = 0; i < result.length; i++)
    {
      String[] tokens = reader.readLine().split(",");
      for(int j = 1; j < tokens.length; j++)
        result[i][j - 1] = Short.parseShort(tokens[j]);
    }

    return result;
  }

  private static short[][] testImages() throws Exception
  {
    BufferedReader reader = new BufferedReader(new FileReader("data/test.csv"));
    short[][] result = new short[28000][784];

    reader.readLine(); // Get rid of header
    for(int i = 0; i < result.length; i++)
    {
      String[] tokens = reader.readLine().split(",");
      for(int j = 0; j < tokens.length; j++)
        result[i][j] = Short.parseShort(tokens[j]);
    }

    return result;
  }

  public static void main(String[] args) throws Exception
  {
    short[][] training = trainingImages();
    short[][] test = testImages();

    Dashboard dashboard = new Dashboard(training, test);
    dashboard.showDashboard();
  }
}