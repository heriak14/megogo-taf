package net.megogo.api;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Comparator;
import java.util.List;
import net.megogo.api.facade.ChannelFacade;
import net.megogo.api.model.Program;
import net.megogo.core.utils.DateTimeUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetChannelTest {

    private final ChannelFacade channelFacade = new ChannelFacade();

    @DataProvider(name = "videoIds")
    public Object[][] provideVideoIds() {
        return new Object[][] {
                {1639111},
                {1585681},
                {1639231}
        };
    }

    @Test(description = "Verify that channel programs are sorted by timestamp ASC", dataProvider = "videoIds")
    public void verifyChannelProgramsAreSortedByTimestamp(int videoId) {
        List<Program> actualPrograms = channelFacade.getChannelPrograms(videoId);
        List<Program> sortedPrograms = actualPrograms.stream()
                .sorted(Comparator.comparingLong(Program::getStartTimestamp))
                .toList();
        assertEquals(actualPrograms, sortedPrograms, "Programs should be sorted by timestamp ASC");
    }

    @Test(description = "Verify that channel has program for current time", dataProvider = "videoIds")
    public void verifyChannelHasProgramForCurrentTime(int videoId) {
        List<Program> actualPrograms = channelFacade.getChannelPrograms(videoId);
        long currentTime = DateTimeUtils.getLocalCurrentTimestamp();
        boolean isProgramForCurrentTimePresent = actualPrograms.stream()
                .anyMatch(program -> program.getStartTimestamp() <= currentTime && program.getEndTimestamp() >= currentTime);
        assertTrue(isProgramForCurrentTimePresent, "Channel should have program for current time");
    }

    @Test(description = "Verify channel don't have programs from the past and far future", dataProvider = "videoIds")
    public void verifyChannelDontHaveProgramsFromThePastAndFarFuture(int videoId) {
        List<Program> actualPrograms = channelFacade.getChannelPrograms(videoId);

        long currentTime = DateTimeUtils.getLocalCurrentTimestamp();
        long oneDayAfterCurrentTime = DateTimeUtils.getLocalTimestampPlusHours(24);
        boolean isProgramFromThePastPresent = actualPrograms.stream()
                .anyMatch(program -> program.getEndTimestamp() < currentTime);
        boolean isProgramFromTheFarFuturePresent = actualPrograms.stream()
                .anyMatch(program -> program.getStartTimestamp() > oneDayAfterCurrentTime);
        assertFalse(isProgramFromThePastPresent, "Channel should not have programs from the past");
        assertFalse(isProgramFromTheFarFuturePresent, "Channel should not have programs from the far future");
    }
}
