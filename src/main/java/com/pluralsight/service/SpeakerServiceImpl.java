package com.pluralsight.service;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service("speakerService")
@Profile("dev")
public class SpeakerServiceImpl implements SpeakerService {

    private SpeakerRepository repository;  // = new HibernateSpeakerRepositoryImpl();

//    @Autowired
    public SpeakerServiceImpl() {
        System.out.println("SpeakerServiceImpl no args constructor");
    }

   @Autowired
    public SpeakerServiceImpl(SpeakerRepository speakerRepository) {
        System.out.println("SpeakerServiceImpl repository constructor");
        repository = speakerRepository;
    }

    @PostConstruct
    private void intialize() {
        System.out.println("We're called after the constructors");
    }

    @Override
    public List<Speaker> findAll() {
        return repository.findAll();
    }

    //@Autowired
    public void setRepository(SpeakerRepository repository) {
        System.out.println("SpeakerServiceImpl setter");
        this.repository = repository;
    }
}