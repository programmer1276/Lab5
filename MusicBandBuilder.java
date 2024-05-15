package Builders;

import Classes.MusicBand;
import Console.MyConsole;
import Managers.CollectionManager;
import Managers.InputHandler;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.util.Arrays;
import java.util.Date;

/**
 * Class to create an object <MusicBand>newBand</MusicBand>
 */
public class MusicBandBuilder implements Builder<MusicBand> {
    static int id = 0;
    CollectionManager manager = CollectionManager.getInstance();
    @Override
    public MusicBand build() {
        checkForEmptySlot();
        MusicBand newBand = new MusicBand(0, null, null, null, 0, null, null, null, null);
        final LocalDate creationDate = LocalDate.now();
        newBand.setCreationDate(creationDate);
        newBand.setId(id);
        return newBand;
    }

    /**
     * Method to update id and for monitoring for empty id slot to add this id to new collection
     */
    private void checkForEmptySlot() {
        if (!(manager.getPreviousIDs().isEmpty())) {
            for (int i = 0; i <= manager.getPreviousIDs().size(); i++) {
                if (!(manager.getPreviousIDs().contains(i))) {
                    id = i;
                    break;
                }
                else {
                    id = manager.getPreviousIDs().size() + 1;
                }
            }
        } else {
            id = 0;
        }
    }
}
