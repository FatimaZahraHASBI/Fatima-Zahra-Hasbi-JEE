package hasbi.fatimazahra.fatimazahrahasbi.MAPPERS;

import hasbi.fatimazahra.fatimazahrahasbi.DAO.entities.Conference;
import hasbi.fatimazahra.fatimazahrahasbi.DTO.ConferenceDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class classMappers {
    public ConferenceDTO fromConference(Conference conference){
        ConferenceDTO conferenceDTO=new ConferenceDTO();
        BeanUtils.copyProperties(conference,conferenceDTO);
        return  conferenceDTO;
    }
    public Conference fromConferenceDTO(ConferenceDTO conferenceDTO){
        Conference conference=new Conference();
        BeanUtils.copyProperties(conferenceDTO, conference);
        return  conference;
    }
}
