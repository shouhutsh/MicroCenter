package cn.edu.zzti.pi.micro_center.util;

import org.springframework.stereotype.Service;

@Service
public class NumberMaker {

    public String getUniqueId(){
        return System.currentTimeMillis() + "001";
    }
}
