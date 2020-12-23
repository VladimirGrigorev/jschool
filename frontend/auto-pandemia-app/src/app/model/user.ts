import {Order} from "./order";

export interface User {
  id: number;
  name: string;
  roles: Array<any>;
  orders: Order[];
}
