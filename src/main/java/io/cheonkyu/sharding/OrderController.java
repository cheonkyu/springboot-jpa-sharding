package io.cheonkyu.sharding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.createOrder(order));
    }

    // @PostMapping
    // public ResponseEntity<Order> createOrder1(@RequestBody Order order) {
    // // System.out.println("1232113");
    // // return null;
    // try {
    // // var a = new Order();
    // // a.setCustomerId(1);
    // // System.out.println(a);
    // // orderService.createOrder(a);
    // return ResponseEntity.ok(null);
    // } catch (Exception e) {

    // System.out.println(e);
    // return ResponseEntity.ok(null);
    // }
    // }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrder(id));
    }
}
