import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;
    Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(feline);
    }


    @Test
    public void catSoundMew() {
        assertEquals("Мяу", cat.getSound());
    }


    @Test
    public void catEatMeat() throws Exception {
        List<String> catEat = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(catEat);
        assertEquals(catEat, cat.getFood());
    }

}
