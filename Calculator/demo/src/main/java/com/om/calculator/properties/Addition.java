package com.om.calculator.properties;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/myCalci")
public class Addition {
    @PostMapping("/add")

    public Integer doAddition(@RequestBody List<Integer> numbers){
        Integer ans=0;
        for(Integer e:numbers){
            ans+=e;
        }
        return ans;

    }
    @PostMapping("/sub")
    public Integer doSubtraction(@RequestBody List<Integer>numbers){
        Integer ans=numbers.get(0);
        for( int i=1;i<numbers.size();i++){
            ans-= numbers.get(i);
        }
        return ans;
    }
    @PostMapping("multiply")
    public Integer doMultiply(@RequestBody List<Integer>numbers){
        Integer ans=1;
        for(Integer e:numbers){
            ans*=e;
        }
        return ans;
    }
    @PostMapping("divide")
    public String doDivision(@RequestBody List<Integer>numbers){
        Double ans=numbers.get(0).doubleValue();
        for(int i=1;i<numbers.size();i++){
            Integer e=numbers.get(i);
            if(e!=0){
                ans/=e.doubleValue();
            }
            else{

                return "Cannot Divide with Zero" ;

            }
        }
        return ans.toString();
    }

}
