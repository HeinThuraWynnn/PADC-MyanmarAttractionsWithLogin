package xyz.aungpyaephyo.padc.myanmarattractions.events;

import java.util.List;

import xyz.aungpyaephyo.padc.myanmarattractions.data.vos.AttractionVO;
import xyz.aungpyaephyo.padc.myanmarattractions.data.vos.UserVO;

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

    public static class UserDataLoadedEvent {
        private String extraMessage;
        private List<UserVO> userVO;

        public UserDataLoadedEvent(String extraMessage, List<UserVO> userVO) {
            this.extraMessage = extraMessage;
            this.userVO = userVO;
        }

        public String getExtraMessage() {
            return extraMessage;
        }

        public List<UserVO> getUserVO() {
            return userVO;
        }

    }
}