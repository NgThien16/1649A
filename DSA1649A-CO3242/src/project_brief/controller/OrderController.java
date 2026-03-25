package project_brief.controller;

import project_brief.library.ArrayListADT;
import project_brief.library.LinkedQueueADT;
import project_brief.model.Order;
import project_brief.model.User;
import project_brief.service.IOrderService;
import project_brief.service.OrderService;
import project_brief.view.OrderView;

public class OrderController {
    private IOrderService orderService = new OrderService();

    public void displayOrder() {
        ArrayListADT<Order> orderList = orderService.getOrderHistory();
        OrderView.displayOrder(orderList);
    }
    public void addOrder(User currentUser){
        System.out.println("Adding Order");
        Order newOrder = OrderView.inputToOrder(currentUser);
        if (newOrder != null) {
            orderService.addOrder(newOrder);
        }
    }
    public void cancelOrder(User currentUser){
        OrderView.cancelOrderByCustomer(currentUser);

    }
    public void approveOrder(){
        OrderView.approveOrder(orderService.getOrder());
    }
    
    public void displayOrderForCustomer(User currentUser){
        ArrayListADT<Order> allOrders = orderService.getOrderHistory();

        OrderView.displayOrderForCustomer(allOrders, currentUser);
    }

    public void searchOrder() {
    }


    public void confirmReceived(User currentUser) {
        OrderView.confirmReceived(currentUser);
    }
}
