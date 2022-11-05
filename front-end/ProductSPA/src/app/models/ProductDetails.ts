export class ProductDetails {
    /**
     *
     */
    constructor(
        public id?: number,
        public productName?: string,
        public initialCartonCount?: number,
        public initialCartonPrice?: number,
        public discountCartonPrice?: number,
        public singleUnitPrice?: number
    ) {
    
        
    }
}
