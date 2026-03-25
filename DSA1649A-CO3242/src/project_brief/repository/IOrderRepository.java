package project_brief.repository;

import project_brief.library.ArrayListADT;
import project_brief.library.LinkedQueueADT;
import project_brief.model.Order;
import project_brief.model.ShippingStatus;

public interface IOrderRepository {
    LinkedQueueADT<Order> getOrder();
    void addOrder(Order order);
    Order deleteOrder(Order order);
    Order findOrderById(int id);
    ArrayListADT<Order> getOrderHistory();


}

