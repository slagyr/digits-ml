package digits;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard
{
  private JPanel dashboardPanel;
  private JButton nextButton;
  private JButton previousButton;
  private JRadioButton trainRadioButton;
  private JRadioButton testRadioButton;
  private JLabel imageNumberLabel;
  private JPanel imagePanel;
  private JPanel optionPanel;
  private JPanel labelPanel;
  private JPanel buttonPanel;

  private final short[][] trainData;
  private final short[][] testData;
  private short[][] currentImageSet;
  private int currentImageIndex = 0;

  public Dashboard(short[][] trainData, short[][] testData)
  {
    this.trainData = trainData;
    this.testData = testData;
  }

  public void showDashboard()
  {
    JFrame frame = new JFrame("Digits Dashboard");
    frame.setContentPane(dashboardPanel);
    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    imageNumberLabel.setText("0");

    trainRadioButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        loadImageSet(trainData);
      }
    });
    testRadioButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        loadImageSet(testData);
      }
    });
    previousButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        loadImage(currentImageIndex - 1);
      }
    });
    nextButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        loadImage(currentImageIndex + 1);
      }
    });

    frame.setLocation(100, 100);
    frame.pack();
    frame.setVisible(true);

//    trainRadioButton.setSelected(true);
//    loadImageSet(trainData);
  }

  private void loadImageSet(short[][] data)
  {
    currentImageSet = data;
    if(currentImageIndex > data.length)
      loadImage(data.length - 1);
    else
      loadImage(currentImageIndex);
  }

  private void loadImage(int i)
  {
    currentImageIndex = i;

    short[] image = currentImageSet[currentImageIndex];
    final Graphics graphics = imagePanel.getGraphics();
    graphics.clearRect(0, 0, 112, 112);
    for(int j = 0; j < image.length; j++)
    {
      int shade = 255 - image[j];
      graphics.setColor(new Color(shade, shade, shade));
      final int x = (j % 28) * 4;
      final int y = (j / 28) * 4;
      graphics.fillRect(x, y, 4, 4);
    }

    imageNumberLabel.setText("" + (i + 1));
    previousButton.setEnabled(i > 0);
    nextButton.setEnabled(i < (currentImageSet.length - 1));
  }

  public static void main(String[] args)
  {
    new Dashboard(new short[10][10], new short[5][5]).showDashboard();
  }
}
