import {SparePart} from "./spare-part";

export interface StoreBranch {
  id: number | null;
  address: string;
  description: string;
  spareParts: SparePart[];
}
