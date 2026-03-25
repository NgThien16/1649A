package project_brief.service;

import project_brief.library.ArrayListADT;
import project_brief.library.LinkedQueueADT;
import project_brief.model.Order;
import project_brief.model.ShippingStatus;
import project_brief.repository.IOrderRepository;
import project_brief.repository.OrderRepository;

public class OrderService implements IOrderService {
    private IOrderRepository orderRepository = new OrderRepository();
    @Override
    public LinkedQueueADT<Order> getOrder() {
        return orderRepository.getOrder();
    }

    @Override
    public ArrayListADT<Order> getOrderHistory() {
        return orderRepository.getOrderHistory();
    }

    @Override
    public void addOrder(Order order) {
        orderRepository.addOrder(order);
    }

    @Override
    public Order deleteOrder(Order order) {
        return orderRepository.deleteOrder(order);
    }

    @Override
    public Order findOrderById(int id) {
        return orderRepository.findOrderById(id);
    }

}
