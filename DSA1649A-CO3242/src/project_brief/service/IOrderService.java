package project_brief.service;

import project_brief.library.ArrayListADT;
import project_brief.library.LinkedQueueADT;
import project_brief.model.Order;
import project_brief.model.ShippingStatus;

public interface IOrderService {
    LinkedQueueADT<Order> getOrder();
    ArrayListADT<Order> getOrderHistory();
    void addOrder(Order order);
    Order deleteOrder(Order order);
    Order findOrderById(int id);



}

