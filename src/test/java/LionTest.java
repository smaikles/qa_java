import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {

    @Mock
    Feline feline;

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }


    String sex;
    boolean hasMane;


    public LionTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Test
    public void getKittensCountCheck() throws Exception {
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        Assert.assertEquals(1, lion.getKittens());
    }

    @Test
    public void doesHaveManeCheck() throws Exception {
        Lion lion = new Lion(sex, feline);
        String message = "Используйте допустимые значения пола животного - самец или самка";
        Assert.assertEquals(message, hasMane, lion.doesHaveMane());
    }

    @Test
    public void getFoodCheck() throws Exception {
        Lion lion = new Lion(sex, feline);
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedList);
        Assert.assertEquals(expectedList, lion.getFood());

    }

}