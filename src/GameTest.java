import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
public class GameTest {

    public Game FPS;
    @BeforeEach
    public void setUp() throws Exception{
        FPS = new Game();
    }

    @Test
    void addKill() {
        FPS.addRound();
        FPS.addRound();
        FPS.addPLayer(0, "XboxKid");
        FPS.addPLayer(1, "XboxKid");
        try {
            FPS.addKill(-1, "PCMasterRace");
            fail();
        }
        catch (IndexOutOfBoundsException ex){

        }
        try {
            FPS.addKill(2, "PCMasterRace");
            fail();
        }
        catch (IndexOutOfBoundsException ex){

        }
        try {
            FPS.addKill(0, "PCMasterRace");
            fail();
        }
        catch (NoSuchElementException ex){

        }
        FPS.addKill(0, "XboxKid");
        assertEquals("1 0 0", FPS.KDAR(0,"XboxKid"));
        FPS.addKill(0, "XboxKid");
        assertEquals("2 0 0", FPS.KDAR(0,"XboxKid"));
        FPS.addKill(1, "XboxKid");
        assertEquals("1 0 0", FPS.KDAR(1,"XboxKid"));
        FPS.addKill(1, "XboxKid");
        assertEquals("2 0 0", FPS.KDAR(1,"XboxKid"));

    }

    @Test
    void addDeath() {
        FPS.addRound();
        FPS.addPLayer(0, "PlaystationBoy");
        try {
            FPS.addDeath(-1, "PCMasterRace");
            fail();
        }
        catch (IndexOutOfBoundsException ex){

        }
        try {
            FPS.addDeath(2, "PCMasterRace");
            fail();
        }
        catch (IndexOutOfBoundsException ex){

        }
        try {
            FPS.addDeath(0, "PCMasterRace");
            fail();
        }
        catch (NoSuchElementException ex){

        }
        FPS.addDeath(0, "PlaystationBoy");
        assertEquals("0 1 0", FPS.KDAR(0,"PlaystationBoy"));
        FPS.addDeath(0, "PlaystationBoy");
        assertEquals("0 2 0", FPS.KDAR(0,"PlaystationBoy"));
    }

    @Test
    void addAssist() {
        FPS.addRound();
        FPS.addRound();
        FPS.addPLayer(0, "SwitchStar");
        FPS.addPLayer(0, "GenericGamer");
        FPS.addPLayer(0, "Minecrafter");
        FPS.addPLayer(1, "SwitchStar");
        try {
            FPS.addAssist(-1, "PCMasterRace");
            fail();
        }
        catch (IndexOutOfBoundsException ex){

        }
        try {
            FPS.addAssist(2, "PCMasterRace");
            fail();
        }
        catch (IndexOutOfBoundsException ex){

        }
        try {
            FPS.addAssist(0, "PCMasterRace");
            fail();
        }
        catch (NoSuchElementException ex){

        }
        FPS.addAssist(0, "SwitchStar");
        assertEquals("0 0 1", FPS.KDAR(0,"SwitchStar"));
        FPS.addAssist(1, "SwitchStar");
        assertEquals("0 0 1", FPS.KDAR(1,"SwitchStar"));
    }

    @Test
    void addPLayer() {
        FPS.addRound();
        FPS.addPLayer(0, "Person");
        FPS.addKill(0, "Person");
        assertEquals("1 0 0", FPS.KDAR(0, "Person"));
    }

    @Test
    void addRound() {
        FPS.addRound();//0
        FPS.addRound();//1
        FPS.addRound();//2
        FPS.addRound();//3
        FPS.addPLayer(3, "Person");
        assertEquals("0 0 0", FPS.KDAR(3, "Person"));
    }

    @Test
    void KDAR() {
        FPS.addRound();
        FPS.addPLayer(0,"SwitchStar");
        FPS.addAssist(0, "SwitchStar");
        assertEquals("0 0 1", FPS.KDAR(0,"SwitchStar"));
        FPS.addAssist(0, "SwitchStar");
        assertEquals("0 0 2", FPS.KDAR(0,"SwitchStar"));
        FPS.addAssist(0, "SwitchStar");
        assertEquals("0 0 3", FPS.KDAR(0,"SwitchStar"));
        FPS.addAssist(0, "SwitchStar");
        assertEquals("0 0 4", FPS.KDAR(0,"SwitchStar"));
        FPS.addAssist(0, "SwitchStar");
        assertEquals("0 0 5", FPS.KDAR(0,"SwitchStar"));
        FPS.addDeath(0, "SwitchStar");
        assertEquals("0 1 5", FPS.KDAR(0,"SwitchStar"));
        FPS.addDeath(0, "SwitchStar");
        assertEquals("0 2 5", FPS.KDAR(0,"SwitchStar"));
        FPS.addKill(0, "SwitchStar");
        assertEquals("1 2 5", FPS.KDAR(0,"SwitchStar"));
        FPS.addKill(0, "SwitchStar");
        assertEquals("2 2 5", FPS.KDAR(0,"SwitchStar"));
        FPS.addKill(0, "SwitchStar");
        assertEquals("3 2 5", FPS.KDAR(0,"SwitchStar"));

    }


}
