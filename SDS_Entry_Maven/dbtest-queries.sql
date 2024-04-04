1) Find total claimed_charge of the exported documents.
Ans:- SELECT SUM(claimed_charge) FROM document where status = "EXPORTED";

2) Find insured_name, insured_address and claimed_charge for the documents that have status "TO_REPRICE" and customer id 1 and 2.
Ans:- SELECT d.insured_name, d.insured_address, d.claimed_charge
     FROM document d
     join batch b ON d.batch_id = b.customer_id
     where d.status = 'TO_REPRICE'
     and b.customer_id in (1, 2);