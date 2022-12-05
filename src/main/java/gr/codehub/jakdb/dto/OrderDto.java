package gr.codehub.jakdb.dto;


import gr.codehub.jakdb.model.Order;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class OrderDto {
    private long id;
    private LocalDateTime date;


    public OrderDto(Order order){
        if (order == null) return;
        id = order.getId();
        date= order.getDate();
    }
    public Order asOrder(){
        Order order = new Order();
        order.setId(id);
        order.setDate(date);
        return order;
    }

}
