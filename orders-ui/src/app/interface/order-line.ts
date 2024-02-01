export interface OrderLine {
  id: number;
  orderId: number;
  customerId: string;
  customerName: string;
  productId: number;
  productName: string;
  quantity: number;
  totalPrice: number;
  date: string;
  followUp: boolean;
}
