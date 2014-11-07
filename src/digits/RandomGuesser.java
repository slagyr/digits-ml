package digits;

import java.util.Random;

public class RandomGuesser implements DigitGuesser
{
  Random random = new Random();

  @Override
  public int guess(short[] data)
  {
    return random.nextInt(10);
  }
}
