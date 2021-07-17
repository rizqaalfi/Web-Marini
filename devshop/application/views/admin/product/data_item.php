<section class="content-header">
      <h1>
        item Barang
      </h1>
      <ol class="breadcrumb">
        <li><a href="<?=site_url('dashboard')?>"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">item</li>
      </ol>
</section>
    
<section class="content">
    <div class ="box">
        <div class="box-header">
            <h3 class="box-title">Data User</h3>
            <div class="pull-right">
                <a href="<?=site_url('item/add')?>" class="btn btn-primary btn-flat">
                    <i class="fa fa-user-plus"></i>Tambah item
                </a>
            </div>
        </div>
        <div class="box-body table-responsive">
            <table class="table table-bordered table-striped" id="table1">
                <thead>
                    <tr>    
                        <th>No</th>
                        <th>kode</th>
                        <th>nama</th>
                        <th>kategori</th>
                        <th>unit</th>
                        <th>harga</th>
                        <th>stok</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <?php $no = 1; 
                    foreach($row->result() as $key=>$data) { ?>
                    <tr>
                        <td style="width:5%;"><?=$no++?></td>
                        <td><?=$data->kode?></td>
                        <td><?=$data->nama?></td>
                        <td><?=$data->kategori?></td>
                        <td><?=$data->unit?></td>
                        <td><?=$data->harga?></td>
                        <td><?=$data->stok?></td>
                        <td class= "text-center" width="160px">
                            <a href="<?=site_url('item/edit/'.$data->id_item)?>" class="btn btn-primary btn-xs">
                                <i class="fa fa-pencil"></i>Edit
                            </a>
                            <a href="<?=site_url('item/del/'.$data->id_item)?>" onclick ="return confirm('Yakin ingin menghapus data??')" class="btn btn-danger btn-primary btn-xs">
                                <i class="fa fa-trash"></i>Delete
                            </a>
                        </td>
                    </tr>
                    <?php
                    }?>
                </tbody> 
            </table>
        </div>
    </div>
</section>
