import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;
import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;
import com.pluralsight.util.CalendarFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Calendar;

@Configuration
@ComponentScan({"com.pluralsight"})  /*this is for autowiring, and where it will search for autowired annotations.
                                      Just need to mark the bean you want as autowired*/
public class AppConfig {

    @Bean(name="cal")
    public CalendarFactory calFactory() {
        CalendarFactory factory= new CalendarFactory();
        factory.addDays(2);
        return factory;
    }

    @Bean
    public Calendar cal() throws Exception {
        return calFactory().getObject();
    }

//    @Bean(name = "speakerService")
//    @Scope(value= BeanDefinition.SCOPE_SINGLETON)
//    public SpeakerService getSpeakerService(){
//        //SpeakerServiceImpl service = new SpeakerServiceImpl(getSpeakerRepository());
//        SpeakerServiceImpl service = new SpeakerServiceImpl();
//        //service.setRepository(getSpeakerRepository());
//        return service;
//    }

//    @Bean(name = "speakerRepository")
//    public SpeakerRepository getSpeakerRepository() {
//
//        return  new HibernateSpeakerRepositoryImpl();
//    }

}
