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
                {"Другое", false},
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
    public void getKittensCountCheck() {
        try {
            Lion lion = new Lion(sex, feline);
            Mockito.when(lion.getKittens()).thenReturn(1);
            Assert.assertEquals(1, lion.getKittens());
        } catch (Exception e) {
            errorMessageCheck(e);
        }
    }

    @Test
    public void doesHaveManeCheck() {
        try {
            Lion lion = new Lion(sex, feline);
            Assert.assertEquals(hasMane, lion.doesHaveMane());
        } catch (Exception e) {
            errorMessageCheck(e);
        }
    }

    @Test
    public void getFoodCheck() {
        try {
            Lion lion = new Lion(sex, feline);
            List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
            Mockito.when(lion.getFood()).thenReturn(expectedList);
            Assert.assertEquals(expectedList, lion.getFood());
        } catch (Exception e) {
            errorMessageCheck(e);
        }
    }

    void errorMessageCheck(Exception e) {
        String message = "Используйте допустимые значения пола животного - самец или самка";
        Assert.assertEquals(message, e.getMessage());
    }
}