import {StoreBranch} from "./store-branch";

export interface SparePart {
  id: number | null;
  name: string;
  description: string;
  count: number;
  cost: number;
  storeBranch: StoreBranch;
}
