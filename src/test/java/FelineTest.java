import com.example.Feline;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class FelineTest {

    Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }


    @Test
    public void felineEatMeat() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        assertEquals(expected, actual);
    }

    @Test
    public void felineEatPlants() throws Exception {
        List<String> expected = List.of("Трава", "Различные растения");
        List<String> actual = feline.getFood("Травоядное");
        assertEquals(expected, actual);
    }

    @Test
    public void kittensReturnsFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void kittensReturnsOne() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void kittensReturnsCount() {
        assertEquals(2, feline.getKittens(2));
    }

}
