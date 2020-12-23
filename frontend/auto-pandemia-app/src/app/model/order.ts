import {SparePart} from "./spare-part";

export interface Order {
  id: number;
  date: any;
  sparePart: SparePart;
}
