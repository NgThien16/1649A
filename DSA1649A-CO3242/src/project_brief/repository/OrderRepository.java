package project_brief.repository;

import project_brief.library.ArrayListADT;
import project_brief.library.LinkedQueueADT;
import project_brief.model.Book;
import project_brief.model.Order;





public class OrderRepository implements IOrderRepository {
    ArrayListADT<Book> items = new ArrayListADT<>();
    private static LinkedQueueADT<Order> orderList = new LinkedQueueADT<>();
    private static ArrayListADT<Order> orderHistory = new ArrayListADT<>();
    @Override
    public LinkedQueueADT<Order> getOrder() {
        return orderList;
    }

    @Override
    public void addOrder(Order order) {
        orderList.offer(order);
        orderHistory.add(order);
    }

    @Override
    public Order deleteOrder(Order order) {
        return orderList.poll();
    }

    @Override
    public Order findOrderById(int id) {
        for (int i = 0; i <orderHistory.size(); i++) {
            Order order =orderHistory.get(i);
            if(order.getOrderID() == id) {
                return order;
            }
        }
        return null;
    }


    @Override
    public ArrayListADT<Order> getOrderHistory() {
        return orderHistory;
    }
}
