import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {OrderService} from "./service/order.service";
import {OrderLine} from "./interface/order-line";
import {CurrencyPipe} from "@angular/common";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CurrencyPipe],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'orders-ui';
  orders: OrderLine[] = [];
  followUpOrders: OrderLine[] = [];
  totalAmount: number = 0;
  itemCount: number = 0;
  constructor(private orderService : OrderService) {}

  ngOnInit() {
    this.orderService.getAllOrders()
      .subscribe(orderLines => {
        this.orders = orderLines;
        for(let orderLine of orderLines) {
          if(orderLine.followUp) {
            this.followUpOrders.push(orderLine);
            this.itemCount += orderLine.quantity;
            this.totalAmount += orderLine.totalPrice;
          }
        }
        console.log(`Order Lines`);
        console.log(orderLines);
      });
  }


  onMarkFollowUp(orderLine: OrderLine, followUp: boolean) {
    this.orderService.markOrderForFollowUp(orderLine.id, followUp).subscribe({
      next: result => {
        if (!followUp) {
          this.followUpOrders = this.followUpOrders.filter(followUpOrder => followUpOrder.id !== orderLine.id);
        } else {
          let inserted = false;
          for(let followUpOrder of this.followUpOrders) {
            if(orderLine.id === followUpOrder.id) {
              inserted = true;
            }
          }
          if (!inserted) {
            this.followUpOrders.push(orderLine);
          }
        }
        this.itemCount = 0;
        this.totalAmount = 0;
        for(let followUpOrder of this.followUpOrders) {
          this.itemCount += followUpOrder.quantity;
          this.totalAmount += followUpOrder.totalPrice;
        }
      },
      error: e => { console.log(e?.error?.detail)}
    })
  }
}
