import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private url = 'http://localhost:5000/api/v1/orders';

  constructor(private httpClient: HttpClient) { }

  getAllOrders(){
    return this.httpClient.get(this.url);
  }

  markOrderForFollowUp(id: number, followUp: boolean) {
    return this.httpClient.patch(`${this.url}/${id}`, {
      id: id,
      followUp: followUp
    });
  }
}
