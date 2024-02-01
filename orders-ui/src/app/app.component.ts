import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {OrderService} from "./service/order.service";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.sass'
})
export class AppComponent {
  title = 'orders-ui';

  constructor(private orderService : OrderService) {}

  ngOnInit() {
    this.orderService.getAllOrders()
      .subscribe(orderLines => {
        console.log(`Order Lines`);
        console.log(orderLines);
      });
  }


  onMarkFollowUp() {
    this.orderService.markOrderForFollowUp(3, true).subscribe({
      next: result => {},
      error: e => { console.log(e?.error?.detail)}
    })
  }
}
