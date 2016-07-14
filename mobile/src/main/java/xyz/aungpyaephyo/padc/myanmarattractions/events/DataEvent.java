package xyz.aungpyaephyo.padc.myanmarattractions.events;

import java.util.List;

import xyz.aungpyaephyo.padc.myanmarattractions.data.vos.AttractionVO;

/**
 * Created by aung on 7/9/16.
 */
public class DataEvent {

    public static class AttractionDataLoadedEvent {
        private String extraMessage;
        private List<AttractionVO> attractionVOList;

        public AttractionDataLoadedEvent(String extraMessage, List<AttractionVO> attractionVOList) {
            this.extraMessage = extraMessage;
            this.attractionVOList = attractionVOList;
        }

        public String getExtraMessage() {
            return extraMessage;
        }

        public List<AttractionVO> getAttractionVOList() {
            return attractionVOList;
        }

    }
}