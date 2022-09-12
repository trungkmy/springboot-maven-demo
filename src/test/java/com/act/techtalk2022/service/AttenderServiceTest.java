//package com.act.techtalk2022.service;
//
//
//import com.act.techtalk2022.controller.request.CreateAttenderRequest;
//import com.act.techtalk2022.controller.request.UpdateAttenderRequest;
//import com.act.techtalk2022.repository.AttenderRepository;
//import com.act.techtalk2022.repository.enitiy.AttenderEntity;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import java.util.List;
//
//import static org.junit.Assert.assertNotNull;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//@RunWith(MockitoJUnitRunner.class)
//public class AttenderServiceTest {
//
//    @InjectMocks
//    private AttenderService attenderService;
//
//    @Mock
//    private AttenderRepository attenderRepository;
//
//    public void setUp() {
//
//    }
//
//    @Test
//    public void test__createAttender__shouldReturnSuccess() {
//        CreateAttenderRequest request = new CreateAttenderRequest();
//
//        AttenderEntity result = attenderService.createAttender(request);
//
//        verify(attenderRepository, times(1)).save(any());
//        assertNotNull(result);
//    }
//
//    @Test
//    public void test__getAllAttenders__shouldReturnSuccess() {
//
//        List<AttenderEntity> result = attenderService.getAllAttenders();
//
//        verify(attenderRepository, times(1)).findAll();
//        assertNotNull(result);
//    }
//
//    @Test
//    public void test__updateAttender__shouldReturnSuccess() {
//        UpdateAttenderRequest request = new UpdateAttenderRequest();
//
//        attenderService.updateAttender(request);
//
//        verify(attenderRepository, times(1)).save(any());
//    }
//
//    @Test
//    public void test__deleteAttender__shouldReturnSuccess() {
//        Integer id = 99;
//
//        attenderService.deleteAttender(id);
//
//        verify(attenderRepository, times(1)).delete(any());
//    }
//}